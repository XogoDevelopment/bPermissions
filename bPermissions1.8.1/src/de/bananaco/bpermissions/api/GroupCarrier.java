package de.bananaco.bpermissions.api;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This class is any object which carries groups. The group references are
 * stored by String, rather than directly as this allows for full loading of all
 * groups before the calculation done by getEffectivePermissions() in Calculable
 * without the recursive nightmare that would ensue.
 */
public abstract class GroupCarrier extends PermissionCarrier {

    private final Set<String> groups;

    @SuppressWarnings({"unchecked", "rawtypes"})
    protected GroupCarrier(Set<String> groups, Set<Permission> permissions,
            String world) {
        super(permissions, world);
        if (groups == null) {
            groups = new HashSet();
        }
        this.groups = groups;
    }

    /**
     * Returns the groups that the object inherits Calculated via the parent
     * object (this is a fresh object every call)
     *
     * @return Set<Group>
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public Set<Group> getGroups() {
        Set<Group> groups = new HashSet();
        for (String name : this.groups) {
            if (WorldManager.getInstance().getWorld(getWorld()) == null) {
                System.err.println(getWorld() + " is null?");
            }
            Group group = (Group) WorldManager.getInstance().getWorld(getWorld()).get(name, CalculableType.GROUP);
            groups.add(group);
        }
        return groups;
    }

    /**
     * Returns the groups that the object inherits This is a direct reference to
     * the object
     *
     * @return
     */
    public Set<String> getGroupsAsString() {
        return groups;
    }

    /**
     * Adds a group to the list of groups
     *
     * @param group
     */
    public void addGroup(String group) {
        group = group.toLowerCase();
        groups.add(group);
    }

    /**
     * Removes a group from the list of groups If no group exists by that name
     * does nothing.
     *
     * @param group
     */
    public void removeGroup(String group) {
        group = group.toLowerCase();
        groups.remove(group);
    }

    /**
     * Shows if the Object has the named group
     *
     * @param group
     * @return boolean
     */
    public boolean hasGroup(String group) {
        for (String g : groups) {
            if (g.equalsIgnoreCase(group)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasGroupRecursive(String group) {
        if (groups.contains(group)) {
            return true;
        }
        for (Group g : getGroups()) {
            if (g.hasGroupRecursive(group)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Used to make saving prettier
     *
     * @return
     */
    public List<String> serialiseGroups() {
        List<String> groups = new ArrayList<String>();
        // Yes, we're lowercasing everything
        List<Group> gr = new ArrayList<Group>(getGroups());
        // also sort it
        sortGroups(gr);
        for (int i = 0; i < gr.size(); i++) {
            groups.add(gr.get(i).getNameLowerCase());
        }
        return groups;
    }

    @Override
    public void clear() {
        this.groups.clear();
        super.clear();
    }
}
