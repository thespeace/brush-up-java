package example.ch15;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

/**
 *          @see InputOutput07_Ex10
 *      - 위의 이전의 파일의 속성을 보여주는 예제에 정렬기능을 추가한 예제이다.
 *        시간이나 파일크기, 이름으로 오름차순 또는 내림차순으로 파일목록을 정렬하여 볼 수 있다.
 *
 *          {@code : 명령 프롬프트(cmd.exe)
 *              ...example>ch15> java InputOutput07_Ex11.java
 *              USAGE : java InputOutput07_Ex11.java SORT_OPTION
 *                  SORT_OPTION :
 *                  t       Time ascending sort.
 *                  T       Time descending sort.
 *                  l       Length ascending sort.
 *                  L       Length descending sort.
 *                  n       Name ascending sort.
 *                  N       Name descending sort.
 *
 *              ...example>ch15> java InputOutput07_Ex11.java T
 *              ...결과 출력...
 *
 *              ...example>ch15> java InputOutput07_Ex11.java L
 *              ...결과 출력...
 *          }
 */
public class InputOutput07_Ex11 {
    public static void main(String[] args) throws IOException {
        if(args.length != 1 || args[0].length() != 1 || "tTlLnN".indexOf(args[0]) == -1) {
            System.out.println("USAGE : java InputOutput07_Ex11 SORT_OPTION");
            System.out.println("    SORT_OPTION :                          ");
            System.out.println("    t       Time ascending sort.           ");
            System.out.println("    T       Time descending sort.          ");
            System.out.println("    l       Length ascending sort.         ");
            System.out.println("    L       Length descending sort.        ");
            System.out.println("    n       Name ascending sort.           ");
            System.out.println("    N       Name descending sort.          ");
            System.exit(0);
        }

        final char option = args[0].charAt(0);

        String currDir = System.getProperty("user.dir");
        File   dir = new File(currDir);
        File[] files = dir.listFiles();

        Comparator comp = new Comparator(){
            public int compare(Object o1, Object o2){
                long time1 = ((File)o1).lastModified();
                long time2 = ((File)o2).lastModified();

                long length1 = ((File)o1).length();
                long length2 = ((File)o2).length();

                String name1 = ((File)o1).getName().toLowerCase();
                String name2 = ((File)o2).getName().toLowerCase();

                int result = 0;

                switch (option) {
                    case 't' :
                        if(time1 - time2 > 0) result = 1;
                        else if(time1 - time2 == 0) result = 0;
                        else if(time1 - time2 < 0) result = -1;
                        break;
                    case 'T' :
                        if(time1 - time2 > 0) result = -1;
                        else if(time1 - time2 == 0) result = 0;
                        else if(time1 - time2 < 0) result = 1;
                        break;
                    case 'l' :
                        if(length1 - length2 > 0) result = 1;
                        else if(length1 - length2 == 0) result = 0;
                        else if(length1 - length2 < 0) result = -1;
                        break;
                    case 'L' :
                        if(length1 - length2 > 0) result = -1;
                        else if(length1 - length2 == 0) result = 0;
                        else if(length1 - length2 < 0) result = 1;
                        break;
                    case 'n' :
                        result = name1.compareTo(name2);
                        break;
                    case 'N' :
                        result = name2.compareTo(name1);
                        break;
                }
                return result;
            }

            public boolean equals(Object o) { return false; } // not used.
        };

        Arrays.sort(files, comp);

        for(int i = 0; i < files.length; i++) {
            File f = files[i];
            String name = f.getName();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String attribute = "";
            String size = "";

            if (files[i].isDirectory()) {
                attribute = "DIR";
            } else {
                size = f.length() + "";
                attribute =  f.canRead()  ? "R" : " ";
                attribute += f.canWrite() ? "W" : " ";
                attribute += f.isHidden() ? "H" : " ";
            }

            System.out.printf("%s %3s %6s %s\n", df.format(new Date(f.lastModified())), attribute, size, name);
        }
    }
}