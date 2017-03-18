package uk.co.umbaska.module.access;

import uk.co.umbaska.modules.UmbaskaModule;

/**
 * @author Andrew Tran
 */
public class AccessModule extends UmbaskaModule{
    @Override
    protected void onEnable() {
        registerSyntaxes();
    }
}
