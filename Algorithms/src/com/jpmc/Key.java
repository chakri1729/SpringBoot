package com.jpmc;

final class Key {
	private final String first, second;

		public Key(String first, String second) {
			super();
			this.first = first;
			this.second = second;
		}

		public String getFirst() {
			return first;
		}

		public String getSecond() {
			return second;
		}

		@Override
		public String toString() {
			return "Key [first=" + first + ", second=" + second + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((first == null) ? 0 : first.hashCode());
			result = prime * result + ((second == null) ? 0 : second.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Key other = (Key) obj;
			if (first == null) {
				if (other.first != null)
					return false;
			} else if (!first.equals(other.first))
				return false;
			if (second == null) {
				if (other.second != null)
					return false;
			} else if (!second.equals(other.second))
				return false;
			return true;
		}

	}

