package word;

public class CutTransform implements TextTransform {
    private StringBuilder lastCut;

    public StringBuilder getLastCut() {
        return this.lastCut;
    }

    @Override
    public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
        this.lastCut = new StringBuilder();
        this.lastCut.append(text, startIndex, endIndex);

        text.delete(startIndex, endIndex);
    }
}
