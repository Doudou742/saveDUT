class tp1_exo2 extends Program {
  void testMinToMaj() {
    assertEquals('A', minToMaj('a'));
    assertEquals('F', minToMaj('f'));
  }
  char minToMaj(char c) {
      char maj = (char) ((int) c - 32); 
      return maj;
  }
  void testMajToMin() {
    assertEquals('a', majToMin('A'));
    assertEquals('p', majToMin('P'));
  }
  char majToMin(char c) {
      char min = (char) ((int) c + 32 );
      return min;
  }
  void testLettreAuHasard() {
    char lettre = lettreAuHasard(); println(lettre);
    assertGreaterThanOrEqual('a', lettre);
    assertLessThanOrEqual('z', lettre);
    // ou: assertTrue('a' <= lettre && lettre <= 'z');
  }
  char lettreAuHasard() {
      
      return '%';
  }
}
