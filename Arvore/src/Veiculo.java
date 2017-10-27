
public class Veiculo implements Comparable<Veiculo> {
	
	Integer placa;

	public Veiculo(Integer placa) {
		this.placa = placa;
	}

	@Override
	public String toString() {
		return "Veiculo [placa=" + placa +"]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((placa == null) ? 0 : placa.hashCode());
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
		
		return true;
	}

	@Override
	public int compareTo(Veiculo o) {
		return this.placa.compareTo(o.placa);
	}
}
