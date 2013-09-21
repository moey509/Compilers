public final class CubexLocation {
	private String mFile;
	private int mLine;
	private int mPos;

	public CubexLocation(String file, int line, int pos) {
		mFile = file;
		mLine = line;
		mPos = pos;
	}
}