import com.lehich.Matrix;
import java.util.Scanner;
import static com.lehich.Matrix.gauss;
import static com.lehich.Matrix.printMatrix;
public class Mass {
    public static void main(String[] args) {
        int n;
        int value;
        Scanner b = new Scanner(System.in);
        System.out.println("Введите размерность квадратной матрицы: ");
        n = b.nextInt();
        Matrix mt = new Matrix();
        mt.setSize(n);
        for (int i=0; i<n; i++){
            int iNum = i+1;
            for (int j=0; j<n; j++) {
                int jNum = j + 1;
                System.out.println("Введите " + jNum + " элемент " + iNum + " столбца: ");
                value = b.nextInt();
                mt.setElem(i, j, value);
            }
        }



//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                  int value = (int) (Math.random()*5);
//                   mt.setElem(i, j, value);
//            }
//        }
        printMatrix(mt);
        double start = System.currentTimeMillis();
        double gauss = gauss(mt, n);
        double finish = System.currentTimeMillis();
        double time = finish - start;
        System.out.println("The time of gauss = " + time);
        System.out.println(gauss);
    }
    }




