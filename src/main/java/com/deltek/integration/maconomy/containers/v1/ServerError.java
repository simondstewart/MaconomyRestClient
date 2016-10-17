package com.deltek.integration.maconomy.containers.v1;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServerError {

	private String errorMessage;
	private String errorFamily;
	private String errorSeverity;
	private ServerError.Focus focus;
	private String data;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(final String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorFamily() {
		return errorFamily;
	}

	public void setErrorFamily(final String errorFamily) {
		this.errorFamily = errorFamily;
	}

	public String getErrorSeverity() {
		return errorSeverity;
	}

	public void setErrorSeverity(final String errorSeverity) {
		this.errorSeverity = errorSeverity;
	}

	public ServerError.Focus getFocus() {
		return focus;
	}

	public void setFocus(final ServerError.Focus focus) {
		this.focus = focus;
	}

	public String getData() {
		return data;
	}

	public void setData(final String data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((errorFamily == null) ? 0 : errorFamily.hashCode());
		result = prime * result + ((errorMessage == null) ? 0 : errorMessage.hashCode());
		result = prime * result + ((errorSeverity == null) ? 0 : errorSeverity.hashCode());
		result = prime * result + ((focus == null) ? 0 : focus.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final ServerError other = (ServerError) obj;
		if (data == null) {
			if (other.data != null) {
				return false;
			}
		} else if (!data.equals(other.data)) {
			return false;
		}
		if (errorFamily == null) {
			if (other.errorFamily != null) {
				return false;
			}
		} else if (!errorFamily.equals(other.errorFamily)) {
			return false;
		}
		if (errorMessage == null) {
			if (other.errorMessage != null) {
				return false;
			}
		} else if (!errorMessage.equals(other.errorMessage)) {
			return false;
		}
		if (errorSeverity == null) {
			if (other.errorSeverity != null) {
				return false;
			}
		} else if (!errorSeverity.equals(other.errorSeverity)) {
			return false;
		}
		if (focus == null) {
			if (other.focus != null) {
				return false;
			}
		} else if (!focus.equals(other.focus)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ServerError [errorMessage=" + errorMessage + ", errorFamily=" + errorFamily + ", errorSeverity="
				+ errorSeverity + ", focus=" + focus + ", data=" + data + "]";
	}

	public static class Focus {

		private int rowNumber;
		private String fieldName;
		private String paneName;

		public int getRowNumber() {
			return rowNumber;
		}

		public void setRowNumber(final int rowNumber) {
			this.rowNumber = rowNumber;
		}

		public String getFieldName() {
			return fieldName;
		}

		public void setFieldName(final String fieldName) {
			this.fieldName = fieldName;
		}

		public String getPaneName() {
			return paneName;
		}

		public void setPaneName(final String paneName) {
			this.paneName = paneName;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((fieldName == null) ? 0 : fieldName.hashCode());
			result = prime * result + ((paneName == null) ? 0 : paneName.hashCode());
			result = prime * result + rowNumber;
			return result;
		}

		@Override
		public boolean equals(final Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			final Focus other = (Focus) obj;
			if (fieldName == null) {
				if (other.fieldName != null) {
					return false;
				}
			} else if (!fieldName.equals(other.fieldName)) {
				return false;
			}
			if (paneName == null) {
				if (other.paneName != null) {
					return false;
				}
			} else if (!paneName.equals(other.paneName)) {
				return false;
			}
			if (rowNumber != other.rowNumber) {
				return false;
			}
			return true;
		}

		@Override
		public String toString() {
			return "Focus [rowNumber=" + rowNumber + ", fieldName=" + fieldName + ", paneName=" + paneName + "]";
		}

	}

}
