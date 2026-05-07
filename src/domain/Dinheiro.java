package domain;

public class Dinheiro {
  private Long centavos;

  private Dinheiro(Long centavos) {
    this.centavos = centavos;
  }

  public static Dinheiro fromReal(Double valor) {
    return new Dinheiro(Math.round(valor));
  }

  public static Dinheiro fromCentavos(Long valor) {
    return new Dinheiro(valor);
  }

  public void somar(Dinheiro dinheiro) {
    this.centavos += dinheiro.centavos;
  }

  public void subtrair(Dinheiro dinheiro) {
    this.centavos -= dinheiro.centavos;
  }

  public Long getCentavos() {
    return centavos;
  }

  @Override
  public String toString() {
    return String.format("R$ %02d,%02d", centavos / 100, centavos % 100);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((centavos == null) ? 0 : centavos.hashCode());
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
    Dinheiro other = (Dinheiro) obj;
    if (centavos == null) {
      if (other.centavos != null)
        return false;
    } else if (!centavos.equals(other.centavos))
      return false;
    return true;
  }
}
