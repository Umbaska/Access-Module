package uk.co.umbaska.module.access.skript.mysql.types;

import ch.njol.skript.classes.ClassInfo;
import ch.njol.skript.classes.Parser;
import uk.co.umbaska.module.access.skript.mysql.types.model.AccessConnection;
import uk.co.umbaska.skript.UmbaskaType;

/**
 * @author Andrew Tran
 */
public class TypeConnection extends UmbaskaType<AccessConnection>{
    @Override
    public ClassInfo<AccessConnection> getClassInfo() {
        return new ClassInfo<AccessConnection>(AccessConnection.class, "uconnection")
            .parser(new Parser<AccessConnection>() {
                @Override
                public String toString(AccessConnection accessConnection, int i) {
                    return "Connection ID: " + accessConnection.getHost();
                }

                @Override
                public String toVariableNameString(AccessConnection accessConnection) {
                    return toString(accessConnection, 0);
                }

                @Override
                public String getVariableNamePattern() {
                    return "Connection ID: %d+";
                }
            });
    }
}
