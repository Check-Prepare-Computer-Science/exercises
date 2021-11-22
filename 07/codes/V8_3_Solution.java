@Test
public void testSubmit() {
  try {
    Product normalProduct = plm.produce("Hausuebungen");
    // Throws an exception
    assertTrue(plm.submit(normalProduct, 89));
    assertThrows(InsufficientQualityException.class, () -> plm.submit(normalProduct, 101));

  } catch (InsufficientQualityException e) {
    fail("InsufficientQualityException thrown");
  }
}