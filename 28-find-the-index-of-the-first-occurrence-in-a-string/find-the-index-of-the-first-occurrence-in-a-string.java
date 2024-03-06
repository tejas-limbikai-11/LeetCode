class Solution {
    public int strStr(String haystack, String needle) {
        return search(haystack, needle);
    }

    private final int PRIME = 101;

  private double calculateHash(String str) {
    double hash = 0;
    for(int i=0; i < str.length(); i++) {
      hash += str.charAt(i) * Math.pow(PRIME, i);
    }
    return hash;
  }

  private double updateHash(double prevHash, char oldChar, char newChar, int patternLength) {
      double newHash = (prevHash - oldChar) / PRIME;
    newHash = newHash + newChar * Math.pow(PRIME, patternLength - 1);
    return newHash;
  }

  public int search(String text, String pattern) {
      if(pattern.length() > text.length()) {
          return -1;
      }
    int patternLength = pattern.length();
    double patternHash = calculateHash(pattern);
    double textHash = calculateHash(text.substring(0, patternLength));

    for(int i=0; i<= text.length() - patternLength; i++) {
      if(textHash == patternHash) {
        if(text.substring(i, i+patternLength).equals(pattern)) {
            return i;
        }
      }

      if (i < text.length() - patternLength) {
        textHash = updateHash(textHash, text.charAt(i), text.charAt(i + patternLength), patternLength);
      }
    }
    return -1;
  }
}