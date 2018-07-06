package ParserUtils;

public class ParserEvent {
	private String agent;
	private String action;
	
	public ParserEvent(String agent, String action) {
		this.agent = agent;
		this.action = action;
	}

	public boolean equals(ParserEvent e) {
		return e.agent == agent && e.action == action;
	}

        public String getAgent() { return agent;}
        public String getAction() { return action;}
}

