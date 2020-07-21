package rules;

import tcore.Composer;
import tcore.Iterator;
import tcore.LHS;
import tcore.Matcher;
import tcore.messages.Match;
import tcore.messages.Packet;

/**
 * Applies an inner rule for each match of the LHS.
 *
 * @author Pierre-Olivier Talbot
 */
public class LRule extends Composer {

    private String name;
    protected Composer innerRule;
    protected Matcher matcher;

    LRule(String name, Composer innerRule, LHS lhs) {
        this.name = name;
        this.innerRule = innerRule;
        matcher = new Matcher(lhs, Integer.MAX_VALUE);
    }

    @Override
    public Packet packetIn(Packet p) {
        p = matcher.packetIn(p);
        if (checkModuleForFailure(matcher)) return p;

        int size = p.getCurrentMatchSet().getMatches().size();
        for (int i = 0; i < size; i++) {
            p = innerRule.packetIn(p);
            if (checkModuleForFailure(innerRule)) return p;
        }
        isSuccess = true;
        return p;
    }

    // TODO: 2017-12-13 I don't understand these!!!
    @Override
    public Packet nextIn(Packet p) {
        return null;
    }

    public String getName() {
        return name;
    }
}
