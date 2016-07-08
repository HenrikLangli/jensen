package dk.langli.jensen;

import java.util.LinkedList;
import java.util.List;

public class DefaultSecurityFilter implements SecurityFilter {
    private List<String> allowedPackages = new LinkedList<>();

    public DefaultSecurityFilter(List<String> allowedPackages) {
        this.allowedPackages = allowedPackages;
    }

    @Override
    public boolean isAllowed(MethodCall methodCall, Request request) {
        boolean allowed = true;
        if(allowedPackages.size() > 0) {
            allowed = false;
            for(String pck : allowedPackages) {
                if(request.getMethod().startsWith(pck)) {
                    allowed = true;
                    break;
                }
            }
        }
        return allowed;
    }
}
