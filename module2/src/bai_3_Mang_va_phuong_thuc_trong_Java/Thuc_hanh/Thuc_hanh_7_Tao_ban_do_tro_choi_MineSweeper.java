package bai_3_Mang_va_phuong_thuc_trong_Java.Thuc_hanh;
import java.util.Scanner;
public class Thuc_hanh_7_Tao_ban_do_tro_choi_MineSweeper {
    public static void main(String[] args) {
        String[][] map = {
                {"*", ".", "*", ".", "."},
                {".", "*", ".", ".", "."}
        };
        final int MAP_HEIGHT = map.length;
        final int MAP_WIDTH = map[0].length;
        String[][] mapReport = new String[MAP_HEIGHT][MAP_WIDTH];

        for (int yOrdinate = 0; yOrdinate < MAP_HEIGHT; yOrdinate++) {
            for (int xOrdinate = 0; xOrdinate < map[0].length; xOrdinate++) {
                String curentCell = map[yOrdinate][xOrdinate];
                if (curentCell.equals("*")) {
                    mapReport[yOrdinate][xOrdinate] = "*";
                } else {
                    final int[][] NEIGHBOURS_ORDINATE = {
                            {yOrdinate, xOrdinate - 1}, {yOrdinate, xOrdinate + 1}
                    };

                    int minesAround = 0;
                    for (int i = 0; i < NEIGHBOURS_ORDINATE.length; i++) {
                        int[] neighbourOrdinate = NEIGHBOURS_ORDINATE[i];
                        int xOrdinateOfNeighbour = neighbourOrdinate[1];
                        int yOrdinateOfNeighbour = neighbourOrdinate[0];

                        boolean isOutOfMapNeighbour = xOrdinateOfNeighbour < 0 || xOrdinateOfNeighbour == MAP_WIDTH;
                        if (isOutOfMapNeighbour) continue;

                        boolean isMineOwnerNeighbour = map[yOrdinateOfNeighbour][xOrdinateOfNeighbour].equals("*");
                        if (isMineOwnerNeighbour) minesAround++;
                    }
                    for (yOrdinate = 0; yOrdinate < MAP_HEIGHT; yOrdinate++) {
                        for (xOrdinate = 0; xOrdinate < MAP_WIDTH; xOrdinate++) {
                            String currentCellReport = mapReport[yOrdinate][xOrdinate];
                            System.out.print(currentCellReport);
                        }
                    }
                }
            }
        }
    }
}