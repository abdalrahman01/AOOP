/**
 * 
 */
package Excersice5;

/**
 * @author Abd Alrahman
 *
 */
public class Matrix {

	
	int r, c; // numbers of r:rows and c:columns
	
	private double[][]	elements; 
	
	public Matrix(int rows, int cols) throws Exception {
		if (rows <= 0 || cols <= 0)
			throw new Exception("Rows or Cols are negativ  ");
		r = rows; 
		c = cols; 
		elements = new double[r][c];
	}
	
	
	
	/**
	 * @summary Sets at postion (row, col) a new Element
	 * 
	 * 
	 * @param row int the x position 
	 * @param col int the y position
	 * @param newElement double the new element to be set.  
	 * @throws IndexOutOfBoundsException if the row and col are bigger than the actual matrix, or less than 0
	 */
	public void set(int row, int col, double newElement) throws IndexOutOfBoundsException {
		if ( 0 > row || row >= r || 0 > col || col >= c)
			throw new IndexOutOfBoundsException();
		elements[row][col] = newElement; 
	}
	
	
	
	/**
	 * @summary  
	 * @param row int the x position 
	 * @param col int the y position
	 * @return double the element at (row, col)
	 * @throws IndexOutOfBoundsException if the row and col are bigger than the actual matrix, or less than 0
	 */
	public double get(int row, int col) throws IndexOutOfBoundsException{
		
		if ( 0 > row || row >= r || 0 > col || col >= c)
			throw new IndexOutOfBoundsException();
		
		return elements[row][col];
	}
	
	
	
	/**
	 * @summary adds a matrix to this matrix, ONLY if compatible. 
	 * @param thatMatrix Matrix Object 
	 * @throws Exception if the matrices are not compatible
	 * 
	 */
	public void add(Matrix thatMatrix) throws Exception {
		if (thatMatrix.r != r || thatMatrix.c != c)
			throw new Exception("Not compatible matrices! this: (" + r+" ," + c + ") and that:(" + thatMatrix.r + " ," + thatMatrix.c + ")");
		
		for (int col = 0; col < c; col++) {
			for (int row = 0; row < r; row++) {
				elements[row][col] = elements[row][col] + thatMatrix.get(row, col);   
			}
		}
		
	}
	/**
	 * @summary Matrix multiplication.  
	 * @throws Exception The matrices are not in shape of this: (M x N) that: (N x p). 
	 * @param thatMatrix Matrix Object  
	 * @return The dotproduct of this . that
	 */
	
	public Matrix multiply(Matrix thatMatrix) throws Exception {
		if (c != thatMatrix.r)
			throw new Exception("Not compatible matrices! this: (" + r+" ," + c + ") and that:(" + thatMatrix.r + " ," + thatMatrix.c + "), should be (M x N) . (N x k) ");
		Matrix productMatrix = new Matrix(r, thatMatrix.c);
		
		int n = c;
		double sum;
		
		for (int i = 0; i < r; i++) // this matrix' rows
		{
			for (int j = 0; j< thatMatrix.c; j++) // that Matrix' cols 
			{
				sum = 0; 
				for (int k = 0; k < n; k++) {
					sum += elements[i][k] * thatMatrix.get(k, j); 
				}
				productMatrix.set(i, j, sum);
			}
		}
		
		
		return productMatrix;
	
	
	}
	
	public String toString() {
		String result = ""; 
		
		for(int i = 0; i < c; i++) {
			result += "[ ";
			for (int j = 0; j < r; j++) {
				result += elements[j][i] + " ";
			}
			result += "]\n"; 
		}
		
		
		return result; 
	}
	
	
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		int size = 2;
		Matrix A = new Matrix(2,2); 
		Matrix B = new Matrix(2,2);
		
		int a = 0; 
		for(int i = 0; i < size; i++)
			for(int j= 0; j < size; j++)
			{
				A.set(j, i, a++);
			}
		System.out.println(A);
		
		
		int b = 0; 
		for(int i = 0; i < size; i++)
			for(int j= 0; j < size; j++)
			{
				B.set(i, j, b++);
			}
		System.out.println(B);

		Matrix C = A.multiply(B);
		System.out.println(C);
	}

}
