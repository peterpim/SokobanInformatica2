/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import javax.swing.JOptionPane;

/**
 *
 * @author Peter-Pim
 */
public class Maps {
    private Maze maze;
    
    public void setMaze(Maze maze) {
        this.maze = maze;
    }

    private static String level1 = " wwwwwwwwwwwww \n" +
                                   "ww           ww\n" +
                                   "w w    o    w w\n" +
                                   "w  b       b  w\n" +
                                   "w    wewew    w\n" +
                                   "w     wew     w\n" +
                                   "w             w\n" +
                                   "w          p  w\n" +
                                   "w w    b    w w\n" +
                                   "ww           ww\n" +
                                   " wwwwwwwwwwwww   ";

    private static String level2 = "wwwwwwwwwwwwwww\n" +
                                   "w  p   o      w\n" +
                                   "w  b   d      w\n" +
                                   "w b wwwwwww b w\n" +
                                   "w  w e t e w  w\n" +
                                   "w ww e   e ww w\n" +
                                   "w  w       w  w\n" +
                                   "w   w w w w   w\n" +
                                   "    w w w w    \n" +
                                   "     b         \n" +
                                   "wwwww     wwwww  ";

    private static String level3 = "tttwwwwwwwwwttt\n" +
                                   "ttwew  t  wewtt\n" +
                                   "tw           wt\n" +
                                   "w   www www   w\n" +
                                   "w   w b b w   w\n" +
                                   "w d    p      w\n" +
                                   "w   w b b w   w\n" +
                                   "w   www www   w\n" +
                                   "tw           wt\n" +
                                   "ttwew  o  wewtt\n" +
                                   "tttwwwwwwwwwttt\n";

    private static String level4 = "d wwwwwwwwwwwww\n" +
                                   "w             w\n" +
                                   "we e      e e w\n" +
                                   "wwwwwww wwwwwww\n" +
                                   "wt       b   tw\n" +
                                   "w     b       w\n" +
                                   "wwww wwwwwwwwww\n" +
                                   "w  b   b      w\n" +
                                   "w ww wwwww  o w\n" +
                                   "w     p       w\n" +
                                   "wwwwwwwwwwwwwww ";

    private static String level5 = "wwwwwwwwwwwwwww\n" +
                                   "w     w p     w\n" +
                                   "w  o  b  w  b w\n" +
                                   "w  b   ww   b w\n" +
                                   "w w b wttw b ww\n" +
                                   "w  w   tt   www\n" +
                                   "w w   wttw   ww\n" +
                                   "w      ww     w\n" +
                                   "wwwww wd w wwww\n" +
                                   "weee       eeew\n" +
                                   "wwwwwwwwwwwwwww\n";

    private static String level6 = "w  wwwwwwwww  w\n" +
                                   "w   b      b  w\n" +
                                   "w  wwww  www  w\n" +
                                   "w   b wbdw     \n" +
                                   "w   p w  w     \n" +
                                   "w   oww  ww   w\n" +
                                   "wewewwwwwwwewew\n" +
                                   "w w wwwwwww w w\n" +
                                   "w w wwwwwww w w\n" +
                                   "wtwtwwwwwwwtwtw\n" +
                                   "wwwwwwwwwwwwwww\n";

    private static String level7 = "w  wwwwwwwww  w\n" +
                                   "w  b   o   b  w\n" +
                                   "w  w  w w  w  w\n" +
                                   "w  w w b w w  w\n" +
                                   "w  w wbdbw w  w\n" +
                                   "   w w b w w   \n" +
                                   "  ww   p   ww  \n" +
                                   "  ew wwwww we  \n" +
                                   "wew  wwtww  wew\n" +
                                   "wtw e w   e wtw\n" +
                                   "wwwwwww  wwwwww\n";

    private static String level8 = "wwwwwwwtwwwwwww\n" +
                                   "w   wwwowww eew\n" +
                                   "w             w\n" +
                                   "w   wwwbwww   w\n" +
                                   "w   w  p  w w w\n" +
                                   "w  bw  b  wb  w\n" +
                                   "w   w  t  w   w\n" +
                                   "w  wwwwwwwww  w\n" +
                                   "e      b      e\n" +
                                   "weew  bdb  weew\n" +
                                   "wwwt   b   twww\n";

    private static String level9 = "wwwwwwwtwwwwwtt\n" +
                                   "w     w     wtt\n" +
                                   "wtb w  bb    ww\n" +
                                   "w wwwww ww    w\n" +
                                   "wb   t b w o  w\n" +
                                   "w    w   w p  w\n" +
                                   "w    w   wwwwww\n" +
                                   "w    b   wwe ew\n" +
                                   "wbw wwwwwwe   e\n" +
                                   " d b         ew\n" +
                                   "wwwwwwwwwwwweee\n";

    private static String level10 = "we wwewwwwwwwww\n" +
                                    "e e e ew p w  w\n" +
                                    "w ewe  w   wb w\n" +
                                    "w w  www   w  w\n" +
                                    "  w    w  bw  w\n" +
                                    "e    b w  b   t\n" +
                                    "wwwww wwww wwww\n" +
                                    "w      www wwtw\n" +
                                    "w bb o w      w\n" +
                                    "w  w  bdb     w\n" +
                                    "wwwww b twww  w\n";

    private static String testmap1 ="wpb            \n" +
                                    " b             \n" +
                                    " w             \n" +
                                    "               \n" +
                                    "               \n" +
                                    "               \n" +
                                    "               \n" +
                                    "               \n" +
                                    "               \n" +
                                    "               \n" +
                                    "               \n";

    private static String testmap2 ="               \n" +
                                    " p             \n" +
                                    "               \n" +
                                    "               \n" +
                                    "               \n" +
                                    "               \n" +
                                    "               \n" +
                                    "               \n" +
                                    "               \n" +
                                    "               \n" +
                                    "               \n";

    private static String leegveld ="               \n" +
                                    "               \n" +
                                    "               \n" +
                                    "               \n" +
                                    "               \n" +
                                    "               \n" +
                                    "               \n" +
                                    "               \n" +
                                    "               \n" +
                                    "               \n" +
                                    "               \n";


    public String getMap(int value) {
        if(value == 1) {
            return level1;
        } else if(value == 2) {
            return level2;
        } else if (value == 3) {
            return level3;
        } else if(value == 4) {
            return level4;
        } else if(value == 5) {
            return level5;
        } else if(value == 6) {
            return level6;
        } else if(value == 7) {
            return level7;
        } else if(value == 8) {
            return level8;
        } else if(value == 9) {
            return level9;
        } else if(value == 10) {
            return level10;
        } else if(value == 1000) {
            return testmap1;
        } else if(value == 1001) {
            return testmap2;
        } else if(value == 11) {
            String[] opties = {"Play again", "Quit"};
            int answer = JOptionPane.showOptionDialog(null,
                                "Congratulations! You've played through all the levels.",
                                "Done", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE,
                                null, opties, opties[1]);
            if(answer == JOptionPane.YES_OPTION) {
                maze.setLevel(0);
            } else if (answer == JOptionPane.NO_OPTION) {
                System.exit(0);
            }
        } else
            throw new IllegalArgumentException("Incorrect level value");
            return null;
    }
}
