 public int divide(int dividend, int divisor) {
	if (dividend == Integer.MIN_VALUE && divisor == -1) {
		return Integer.MAX_VALUE;
	}
	if (dividend == 0) {
		return 0;
	}
	//计算符号
	int sign = (dividend > 0 ? (divisor > 0 ? 1 : -1) : (divisor > 0 ? -1 : 1));
	dividend = dividend > 0 ? -dividend : dividend;
	divisor = divisor > 0 ? -divisor : divisor;
	int quotient = 0;
	int step = divisor;
	int q = 1;

	while (dividend <= divisor) {
		dividend -= step;
		quotient += q;
		step += step;
		q += q;
		if (dividend - step > divisor) {
			step = divisor;
			q = 1;
		}
	}
	return sign > 0 ? quotient : -quotient;
}