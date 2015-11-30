import java.util.Scanner;

public class VectorAddMul {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println(
					"1. Addition\n2. Subtraction\n3. Scalar Multiplication\n4. Vector Multiplication\n5. Exit\n");
			System.out.println("Enter choice : ");
			int choice = sc.nextInt();
			if (choice >= 5)
				System.exit(0);
			System.out.println("Enter values for A : ");

			Vector a = new Vector(sc.nextInt(), sc.nextInt(), sc.nextInt());
			System.out.println("Enter values for B : ");

			Vector b = new Vector(sc.nextInt(), sc.nextInt(), sc.nextInt());
			Vector c = new Vector(0, 0, 0);
			switch (choice) {
			case 1:
				c = addVectors(a, b);
				System.out.println(c.printVector());
				break;
			case 2:
				c = addVectors(a, b);
				System.out.println(c.printVector());
				break;
			case 3:
				c = addVectors(a, b);
				System.out.println(c.printVector());
				break;
			case 4:
				c = addVectors(a, b);
				System.out.println(c.printVector());
				break;

			default:
				System.exit(0);
			}
		}
	}

	public static class Vector {
		int x, y, z;

		public String printVector() {
			return ("( " + x + "X " + y + "Y " + z + "Z" + " )");
		}

		public Vector(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}

		public void setX(int x) {
			this.x = x;
		}

		public void setY(int y) {
			this.y = y;
		}

		public void setZ(int z) {
			this.z = z;
		}

		public int getX() {
			return this.x;
		}

		public int getY() {
			return this.y;
		}

		public int getZ() {
			return this.z;
		}
	}

	public static Vector addVectors(Vector a, Vector b) {
		Vector c = new Vector(0, 0, 0);
		System.out.println("Addition : " + a.printVector() + " + " + b.printVector());
		c.setX(a.getX() + b.getX());
		c.setY(a.getY() + b.getY());
		c.setZ(a.getZ() + b.getZ());
		return c;
	}

	public static Vector subtractVectors(Vector a, Vector b) {
		Vector c = new Vector(0, 0, 0);
		System.out.println("Subtraction : " + a.printVector() + " - " + b.printVector());
		c.setX(a.getX() - b.getX());
		c.setY(a.getY() - b.getY());
		c.setZ(a.getZ() - b.getZ());

		return c;
	}

	public static Vector scalarMultiplyVectors(Vector a, Vector b) {
		Vector c = new Vector(0, 0, 0);
		System.out.println("Scalar Multiplication : " + a.printVector() + " . " + b.printVector());
		c.setX(a.getX() * b.getX());
		c.setY(a.getY() * b.getY());
		c.setZ(a.getZ() * b.getZ());

		return c;
	}

	public static Vector vectorMultiplyVectors(Vector a, Vector b) {
		Vector c = new Vector(0, 0, 0);
		System.out.println("Vector Multiplication : " + a.printVector() + " X " + b.printVector());
		c.setX(a.getY() * b.getZ() - a.getZ() * b.getY());
		c.setY(a.getZ() * b.getX() - a.getX() * b.getZ());
		c.setZ(a.getX() * b.getY() - a.getY() * b.getX());
		return c;
	}
}
