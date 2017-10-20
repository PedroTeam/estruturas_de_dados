
public class Veiculo implements Comparable<Veiculo> {
	
	String placa;
	Integer velocidade;

	public Veiculo(String placa, Integer velocidade) {
		this.placa = placa;
		this.velocidade = velocidade;
	}

	@Override
	public String toString() {
		return "Veiculo [placa=" + placa + ", velocidade=" + velocidade + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((placa == null) ? 0 : placa.hashCode());
		result = prime * result + ((velocidade == null) ? 0 : velocidade.hashCode());
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
		Veiculo other = (Veiculo) obj;
		if (placa == null) {
			if (other.placa != null)
				return false;
		} else if (!placa.equals(other.placa))
			return false;
		if (velocidade == null) {
			if (other.velocidade != null)
				return false;
		} else if (!velocidade.equals(other.velocidade))
			return false;
		return true;
	}

	@Override
	public int compareTo(Veiculo o) {
		return this.placa.compareTo(o.placa);
	}
}
