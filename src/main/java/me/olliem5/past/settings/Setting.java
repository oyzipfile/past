package me.olliem5.past.settings;

import me.olliem5.past.Past;
import me.olliem5.past.module.Module;

import java.util.ArrayList;

public class Setting {
    private Module parent;
    private String name;
    private String id;
    private String type;
    private int min;
    private int start;
    private int max;
    private boolean bval;
    private String sval;
    private ArrayList<String> modes;

    public Setting(String name, String id, int min, int start, int max, Module module) {
        this.parent = module;
        this.name = name;
        this.id = id;
        this.min = min;
        this.start = start;
        this.max = max;
        this.type = "intslider";
    }

    public Setting(String name, String id, boolean bval, Module module) {
        this.parent = module;
        this.name = name;
        this.id = id;
        this.bval = bval;
        this.type = "boolean";
    }

    public Setting(String name, String id, Module module, ArrayList<String> modes, String sval) {
        this.parent = module;
        this.name = name;
        this.id = id;
        this.sval = sval;
        this.modes = modes;
        this.type = "mode";
    }

    public int getValueInt() { return this.start; }
    public boolean getValBoolean() { return this.bval; }
    public String getValueString() { return this.sval; }

    public String getType() { return type; }
    public String getName() { return name; }

    public int getMin() { return min; }
    public int getStart() { return start; }
    public int getMax() { return max; }

    public String getId() { return id; }

    public Module getParent() { return parent; }

    public ArrayList<String> getModes() { return this.modes; }

    public void setValueInt(final int value) {
        this.start = value;

        if (Past.configUtil != null) { try { Past.configUtil.saveIntegers(); } catch (Exception e) {} }
    }

    public void setValBoolean(boolean value) {
        this.bval = value;

        if (Past.configUtil != null) { try { Past.configUtil.saveBooleans(); } catch (Exception e) {} }
    }

    public void setValueString(String value) {
        this.sval = value;

        if (Past.configUtil != null) { try { Past.configUtil.saveModes(); } catch (Exception e) {} }
    }
}
