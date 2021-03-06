package edu.ntut.java007.farmerCoop.model;

/**
 * SattnId generated by hbm2java
 */
public class SattnId implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer userOid;
	private Integer userFarmerOid;

	public SattnId() {
	}

	public SattnId(Integer userOid, Integer userFarmerOid) {
		this.userOid = userOid;
		this.userFarmerOid = userFarmerOid;
	}

	public Integer getUserOid() {
		return this.userOid;
	}

	public void setUserOid(Integer userOid) {
		this.userOid = userOid;
	}

	public Integer getUserFarmerOid() {
		return this.userFarmerOid;
	}

	public void setUserFarmerOid(Integer userFarmerOid) {
		this.userFarmerOid = userFarmerOid;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SattnId))
			return false;
		SattnId castOther = (SattnId) other;

		return (this.getUserOid() == castOther.getUserOid())
				&& (this.getUserFarmerOid() == castOther.getUserFarmerOid());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getUserOid();
		result = 37 * result + this.getUserFarmerOid();
		return result;
	}

}
