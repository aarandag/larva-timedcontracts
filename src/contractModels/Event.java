package contractModels;

public class Event {
	private String agent;
	private String action;
	
	public Event(String agent, String action) {
		this.agent = agent;
		this.action = action;
	}

	public boolean equals(Event e) {
		return e.agent == agent && e.action == action;
	}

        public String getAgent() { return agent;}
        public String getAction() { return action;}
}
