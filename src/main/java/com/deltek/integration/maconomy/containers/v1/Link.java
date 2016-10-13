package com.deltek.integration.maconomy.containers.v1;

public class Link {

	private String rel;
	private String href;
	private String template;

	public String getRel() {
		return rel;
	}

	public void setRel(final String rel) {
		this.rel = rel;
	}

	public String getHref() {
		return href;
	}

	public void setHref(final String href) {
		this.href = href;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(final String template) {
		this.template = template;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((href == null) ? 0 : href.hashCode());
		result = prime * result + ((rel == null) ? 0 : rel.hashCode());
		result = prime * result + ((template == null) ? 0 : template.hashCode());
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
		final Link other = (Link) obj;
		if (href == null) {
			if (other.href != null) {
				return false;
			}
		} else if (!href.equals(other.href)) {
			return false;
		}
		if (rel == null) {
			if (other.rel != null) {
				return false;
			}
		} else if (!rel.equals(other.rel)) {
			return false;
		}
		if (template == null) {
			if (other.template != null) {
				return false;
			}
		} else if (!template.equals(other.template)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Link [rel=" + rel + ", href=" + href + ", template=" + template + "]";
	}

}
