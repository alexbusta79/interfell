package interfell.vehicle.miles.command;

import interfell.vehicle.miles.exceptions.InterfellForbiddenException;
import interfell.vehicle.miles.utils.LoggerUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseCommand<R> {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    protected boolean canExecute() throws InterfellForbiddenException {
        return true;
    }

    protected R doExecute() throws Exception {
        return null;
    }

    public R execute() throws Exception {
        if(canExecute())
            return doExecute();
        else
            throw new InterfellForbiddenException(LoggerUtils.formatArchRow("Cannot execute command"));
    }
}
