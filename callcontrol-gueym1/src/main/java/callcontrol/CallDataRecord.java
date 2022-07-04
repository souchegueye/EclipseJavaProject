package callcontrol;

import java.time.Duration;
import java.time.LocalDateTime;


/**
 * @author Mohamed Gueye
 *
 */
public class CallDataRecord {
	private PhoneNumber callingParty;
	private PhoneNumber calledParty;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private Duration duration;
	private boolean running = false;

	public CallDataRecord(PhoneNumber callingParty, PhoneNumber calledParty) {
		this.callingParty = callingParty;
		this.calledParty = calledParty;
	}

	public PhoneNumber getCallingParty() {
		return this.callingParty;
	}

	public PhoneNumber getCalledParty() {
		return this.calledParty;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void establish() {
		if (running)
			return;
		running = true;
		this.startTime = LocalDateTime.now();
	}

	public void disconnect() {

		if (!running)
			return;
		running = false;
		this.endTime = LocalDateTime.now();
		this.duration = Duration.between(this.startTime, this.endTime);
	}

	@Override
	public String toString() {
		String start = "start: not yet established";
		String end = this.endTime == null ? "" : ", end: " + this.endTime.toString();
		if (this.startTime != null) {
			start = "start: " + this.startTime.toString();
		}
		if (running) {
			end = ", end: still established";
		}
		return "calling: " + callingParty + ", called: " + calledParty + ", " + start + end;
	}
}
