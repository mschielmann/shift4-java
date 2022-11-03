package com.shift4.response;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shift4.enums.DisputeReason;
import com.shift4.enums.DisputeStatus;
import com.shift4.util.Shift4Utils;

import java.util.HashMap;
import java.util.Map;

public class Dispute {

	private String id;
	private Long created;
	private Long updated;

	private Integer amount;
	private String currency;

	private String status;
	private String reason;

	private Boolean acceptedAsLost;

	private DisputeEvidence evidence;
	private DisputeEvidenceDetails evidenceDetails;

	private Charge charge;

	@JsonIgnore
	private final Map<String, Object> other = new HashMap<>();

	public String getId() {
		return id;
	}

	public Long getCreated() {
		return created;
	}

	public Long getUpdated() {
		return updated;
	}

	public Integer getAmount() {
		return amount;
	}

	public String getCurrency() {
		return currency;
	}

	public DisputeStatus getStatus() {
		return DisputeStatus.fromValue(status);
	}

	public String getStatusAsString() {
		return status;
	}

	public DisputeReason getReason() {
		return DisputeReason.fromValue(reason);
	}

	public String getReasonAsString() {
		return reason;
	}

	public Boolean getAcceptedAsLost() {
		return acceptedAsLost;
	}

	public DisputeEvidence getEvidence() {
		return evidence;
	}

	public DisputeEvidenceDetails getEvidenceDetails() {
		return evidenceDetails;
	}

	public Charge getCharge() {
		return charge;
	}

	public String get(String name) {
		return Shift4Utils.toStringNullSafe(other.get(name));
	}

	@JsonAnySetter
	private void set(String name, Object value) {
		other.put(name, value);
	}
}
