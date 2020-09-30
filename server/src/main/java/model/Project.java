package model;

public class Project {
		private String titulo;
		private String descricao;
		private String palavrasChaves;
		private String tipo;
		private int id;
		private int userId;
		
		
		@Override
		public String toString() {
			return "Project [titulo=" + titulo + ", descricao=" + descricao + ", palavrasChaves=" + palavrasChaves
					+ ", tipo=" + tipo + ", id=" + id + ", userId=" + userId + "]";
		}

				
		public Project(int id, int userId, String titulo, String descricao, String palavrasChaves, String tipo) {
			super();
			this.titulo = titulo;
			this.descricao = descricao;
			this.palavrasChaves = palavrasChaves;
			this.tipo = tipo;
			this.setId(id);
			this.setUserId(userId);
		}




		public String getTitulo() {
			return titulo;
		}
		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}
		public String getDescricao() {
			return descricao;
		}
		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}
		public String getPalavrasChaves() {
			return palavrasChaves;
		}
		public void setPalavrasChaves(String palavrasChaves) {
			this.palavrasChaves = palavrasChaves;
		}
		public String getTipo() {
			return tipo;
		}
		public void setTipo(String tipo) {
			this.tipo = tipo;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}
}
