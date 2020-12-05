package game;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.websocket.Session;
import java.io.IOException;
import java.util.UUID;

// 通过这个类来表示一个房间.
// 每两个玩家就构成了一个房间, 由于服务器的玩家可能很多,
// 此时程序 中就会存在多个房间实例(不是单例)
public class Room {
    public static class PutChessResponse {
        public String type = "putChess";
        public int userId;
        public int row;
        public int col;
        public int winner;
    }

    private String roomId;
    private int playerId1;
    private int playerId2;

    // 房间除了需要记录玩家信息之外, 还需要记录游戏状态.
    // 当前棋盘是啥样的.
    // 使用二维数组来表示棋盘当前的状态
    private static final int MAX_ROW = 15;
    private static final int MAX_COL = 15;
    // 棋盘中的每个元素是个整数. 约定:
    // 为 0 表示该位置是空的.
    // 为 1 表示该位置是玩家 1 的子
    // 为 2 表示该位置是玩家 2 的子
    private int[][] chessBoard = new int[MAX_ROW][MAX_COL];

    // 一会需要处理 json, 准备一个 gson 对象
    private Gson gson = new GsonBuilder().create();

    public Room() {
        // 构造方法中只需要生成房间 id 即可
        // 其他 属性 都是匹配/玩家对弈过程中设定的.
        // roomId 要保证唯一性
        // 此处咱们使用 uuid 来直接生成即可(把 roomId 搞成 String 的原因)
        roomId = UUID.randomUUID().toString();
    }

    public int getPlayerId1() {
        return playerId1;
    }

    public void setPlayerId1(int playerId1) {
        this.playerId1 = playerId1;
    }

    public int getPlayerId2() {
        return playerId2;
    }

    public void setPlayerId2(int playerId2) {
        this.playerId2 = playerId2;
    }

    public String getRoomId() {
        return roomId;
    }

    public void putChess(GameAPI.Request request) throws IOException {
        // 1. 进行落子
        int chess = request.userId == playerId1 ? 1 : 2;
        int row = request.row;
        int col = request.col;
        if (chessBoard[row][col] != 0) {
            // 此时说明该 row / col 位置已经有子了.
            // 请求有误
            System.out.println("落子位置有误! " + request);
            return;
        }
        chessBoard[row][col] = chess;
        // 可以把棋盘打印出来, 方便调试问题.
        printChessBoard();
        // 2. TODO 检查游戏是否结束.
        int winner = checkWinner(row, col, chess);
        // 3. 把响应写回给客户端
        //    需要给两个玩家都发送响应对象. 两个玩家发同一个对象即可.
        PutChessResponse response = new PutChessResponse();
        response.userId = request.userId;
        response.row = row;
        response.col = col;
        response.winner = winner;
        // 给玩家写数据, 就需要获取到玩家的 session 对象.
        // 可以通过在线用户列表获取到这个对象.
        OnlineUserManager manager = OnlineUserManager.getInstance();
        Session session1 = manager.getSession(playerId1);
        Session session2 = manager.getSession(playerId2);
        if (session1 == null) {
            // 玩家 1 断线, 就直接认为, 玩家 2 获胜
            response.winner = playerId2;
        } else if (session2 == null) {
            // 玩家 2 断线, 就直接认为, 玩家 1 获胜
            response.winner = playerId1;
        }
        //把responce对象转为json对象
        String respJson = gson.toJson(response);
        if (session1 != null) {
            session1.getBasicRemote().sendText(respJson);
        }
        if (session2 != null) {
            session2.getBasicRemote().sendText(respJson);
        }
        // 4. 如果胜负已分, 此时该房间就可以被销毁了.
        if (response.winner != 0) {
            RoomManager.getInstance().removeRoom(roomId);
            System.out.println("游戏结束, 房间已经销毁! roomId: " + roomId);
        }
    }

    private void printChessBoard() {
        // 此处就不打印边框了, 就让程序猿自己能看懂就行了.
        System.out.println("打印棋盘信息");
        System.out.println("===========================");
        for (int r = 0; r < MAX_ROW; r++) {
            for (int c = 0; c < MAX_COL; c++) {
                System.out.print(chessBoard[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println("===========================");
    }

    private int checkWinner(int row, int col, int chess) {
        // 是否分出胜负
        boolean done = false;
        // 1. 检查所有行
        for (int c = col - 4; c <= col; c++) {
            if (c < 0 || c >= MAX_COL) {
                continue;
            }
            if (chessBoard[row][c] == chess
                    && chessBoard[row][c+1] == chess
                    && chessBoard[row][c+2] == chess
                    && chessBoard[row][c+3] == chess
                    && chessBoard[row][c+4] == chess
            ) {
                done = true;
            }
        }
        // 2. 检查所有列
        for (int r = row - 4; r <= row; r++) {
            if (r < 0 || r >= MAX_ROW) {
                continue;
            }
            if (chessBoard[r][col] == chess
                    && chessBoard[r+1][col] == chess
                    && chessBoard[r+2][col] == chess
                    && chessBoard[r+3][col] == chess
                    && chessBoard[r+4][col] == chess
            ) {
                done = true;
            }
        }
        // 3. 判断左对角线
        for (int r = row - 4, c = col - 4; r <= row && c <= col; r++, c++) {
            if (r < 0 || r >= MAX_ROW || c < 0 || c >= MAX_COL) {
                continue;
            }
            if (chessBoard[r][c] == chess
                    && chessBoard[r+1][c+1] == chess
                    && chessBoard[r+2][c+2] == chess
                    && chessBoard[r+3][c+3] == chess
                    && chessBoard[r+4][c+4] == chess
            ) {
                done = true;
            }
        }
        // 4. 判断右对角线
        for (int r = row - 4, c = col + 4; r <= row && c >= col; r++, c--) {
            if (r < 0 || r >= MAX_ROW || c < 0 || c >= MAX_COL) {
                continue;
            }
            if (chessBoard[r][c] == chess
                    && chessBoard[r+1][c-1] == chess
                    && chessBoard[r+2][c-2] == chess
                    && chessBoard[r+3][c-3] == chess
                    && chessBoard[r+4][c-4] == chess
            ) {
                done = true;
            }
        }
        if (!done) {
            return 0;
        }
        return chess == 1 ? playerId1 : playerId2;
    }
}