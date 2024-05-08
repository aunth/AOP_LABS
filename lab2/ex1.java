
class RectangularParallelepiped {
	private float Length;
	private float Width;
	private float Height;

	public RectangularParallelepiped(float l, float w, float h) {
		this.Height = h;
		this.Length = l;
		this.Width = w;
	}

	public float BorderSum() {
		return 2 * (this.Length * this.Height + this.Height * this.Width + this.Length * this.Width);
	}

	public float Volume() {
		return this.Length * this.Height * this.Width;
	}
}

public class ex1 {
	public static void main(String[] argv) {

		RectangularParallelepiped r = new RectangularParallelepiped(5f, 4f, 3f);

		System.out.println(r.BorderSum());
		System.out.println(r.Volume());

	}
}