package com.my.Types;

public class EN {
	interface Operation {
		int apply(int x, int y);
	}

	enum BasicOperation implements Operation {
		PLUS("+") {
			@Override
			public int apply(int x, int y) {
				return x + y;
			}
		},
		MINUS("-") {
			@Override
			public int apply(int x, int y) {
				return x - y;
			}
		},
		TIMES("*") {
			@Override
			public int apply(int x, int y) {
				return x * y;
			}
		},
		DIVIDE("/") {
			@Override
			public int apply(int x, int y) {
				return x / y;
			}
		};

		private String symbol;

		BasicOperation(String symbol) {
			this.symbol = symbol;
		}

		@Override
		public String toString() {
			return symbol;
		}
	}

	enum ExtendedOperation implements Operation {
		EXP("^") {
			@Override
			public int apply(int x, int y) {
				return (int) Math.pow(x, y);
			}
		},
		REMINDER("%") {
			@Override
			public int apply(int x, int y) {
				return x % y;
			}
		},
		TEST() {

			@Override
			public int apply(int x, int y) {
				return x == y ? 1 : 0;
			}

		};
		private String symbol;

		ExtendedOperation(String symbol) {
			this.symbol = symbol;
		}

		ExtendedOperation() {
			this.symbol = "test";
		}

		@Override
		public String toString() {
			return symbol;
		}
	}

	public static void main(String[] args) {
		test(ExtendedOperation.class, 4, 2);
		test(BasicOperation.class, 4, 2);
	}

	private static <T extends Enum<T> & Operation> void test(Class<T> opSet, int x, int y) {
		for (Operation op : opSet.getEnumConstants()) {
			System.out.printf("%d %s %d = %d%n", x, op, y, op.apply(x, y));
		}
	}
}
