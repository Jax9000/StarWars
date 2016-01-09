/**
 * 
 */
package starWars;

/**
 * Auxiliary class designated to run rules in random order
 * @author JJax
 *
 */
public class Ranking {
	
	public Ranking(int ruleId, int random)
	{
		this.ruleId = ruleId;
		this.order = random;
	}
	
	public int getRuleId() {
		return ruleId;
	}
	public void setRuleId(int ruleId) {
		this.ruleId = ruleId;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	private int ruleId;
	private int order;
}

