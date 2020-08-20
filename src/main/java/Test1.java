import org.junit.Test;
import org.ujmp.core.DenseMatrix;
import org.ujmp.core.Matrix;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Test1 {
    @Test
    public void testUJMPTranspose() {
        Matrix denseTransResult = DenseMatrix.Factory.zeros(2, 2);
        denseTransResult.setAsInt(1, 0, 0);
        denseTransResult.setAsInt(1, 0, 1);
        denseTransResult.setAsInt(1, 1, 0);
        denseTransResult.setAsInt(3, 1, 1);

        Matrix dense = DenseMatrix.Factory.zeros(2, 2);
        for (int i = 0; i < dense.getRowCount(); ++i) {
            for (int j = 0; j < dense.getColumnCount(); ++j) {
                // 进行矩阵的赋值，其中第一个参数是值，第二个参数是行，第三个参数是列
                dense.setAsInt((i * j + (int) (Math.pow(i + 1, j))), i, j);
            }
        }
        // 调用矩阵转置转置方法
        Matrix transpose = dense.transpose();

        for (int i = 0; i < dense.getRowCount(); ++i) {
            for (int j = 0; j < dense.getColumnCount(); ++j) {
                assertEquals(transpose.getAsInt(i, j), denseTransResult.getAsInt(i, j));
            }
        }
    }

    @Test
    public void testUJMPDet() {
        int detResult = 2;
        Matrix dense = DenseMatrix.Factory.zeros(2, 2);
        for (int i = 0; i < dense.getRowCount(); ++i) {
            for (int j = 0; j < dense.getColumnCount(); ++j) {
                // 进行矩阵的赋值，其中第一个参数是值，第二个参数是行，第三个参数是列
                dense.setAsInt((i * j + (int) (Math.pow(i + 1, j))), i, j);
            }
        }
        //求矩阵的行列式
        int determiant = (int) dense.det();
        assertEquals(determiant, detResult);
    }

    @Test
    public void testUJMPMock() {
        // 用 mock 替换掉 Matrix
        Matrix dense = mock(Matrix.class);
        // 规定运行到 det() 方法就返回 1.0
        when(dense.det()).thenReturn(1.0);

        //运行 det()，测试返回结果是否符合要求
        assertEquals(3,(int)dense.det());
    }
}