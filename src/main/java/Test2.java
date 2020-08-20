import org.junit.Test;
import org.ujmp.core.DenseMatrix;
import org.ujmp.core.Matrix;

import static org.junit.Assert.assertEquals;

public class Test2 {
    @Test
    public void testUJMPMulData(){
        Matrix denseTransResult = DenseMatrix.Factory.zeros(2, 2);
        denseTransResult.setAsInt(2,0,0);
        denseTransResult.setAsInt(2,0,1);
        denseTransResult.setAsInt(2,1,0);
        denseTransResult.setAsInt(6,1,1);
        Matrix dense = DenseMatrix.Factory.zeros(2, 2);
        for (int i = 0; i < dense.getRowCount(); ++i){
            for (int j = 0 ; j < dense.getColumnCount(); ++j){
                // 进行矩阵的赋值，其中第一个参数是值，第二个参数是行，第三个参数是列
                dense.setAsInt((i*j + (int)(Math.pow(i + 1, j))), i, j);
            }
        }
        // 数乘
        Matrix scaled = dense.times(2.0);

        for (int i=0; i < dense.getRowCount(); ++i){
            for (int j = 0 ; j < dense.getColumnCount(); ++j){
                assertEquals(scaled.getAsInt(i,j), denseTransResult.getAsInt(i,j));
            }
        }
    }
}
