package callcontrol;

/**
 * @author Mohamed Gueye
 *
 */
public class CallControl {
	private PhoneNumber localParty;

	private CallDataRecord callDataRecord;

	enum CallState {
		IDLE, ALERTING, DIALING, CONNECTED, DISCONNECTED, RELEASED
	}

	private CallState state;

	public CallControl(PhoneNumber localParty) {
		this.localParty = localParty;
		state = CallState.IDLE;
	}

	public CallDataRecord dial(PhoneNumber calledParty) {

		if (this.state == CallState.IDLE) {
			this.state = CallState.DIALING;
			this.callDataRecord = new CallDataRecord(localParty, calledParty);
		}
		return this.callDataRecord;
	}

	public CallDataRecord alert(PhoneNumber callingParty) {

		if (this.state == CallState.IDLE) {
			this.callDataRecord = new CallDataRecord(callingParty, localParty);
			this.state = CallState.ALERTING;
		}

		return this.callDataRecord;
	}

	public CallDataRecord getCDR() {
		return this.callDataRecord;
	}

	public void connect() {

		if (this.state == CallState.ALERTING) {
			this.callDataRecord.establish();
			this.state = CallState.CONNECTED;
		}

	}

	public void disconnect() {
		if (this.state == CallState.CONNECTED) {
			this.callDataRecord.disconnect();
			this.state = CallState.DISCONNECTED;
		}
	}

	public CallState getState() {

		return this.state;
	}

	public void alert() {

		if (this.state == CallState.DIALING) {
			this.state = CallState.ALERTING;
		}

	}

	public void release() {
		if (this.state == CallState.IDLE || this.state == CallState.DISCONNECTED || this.state == CallState.ALERTING
				|| this.state == CallState.DIALING) {
			this.state = CallState.RELEASED;
		}

	}

}