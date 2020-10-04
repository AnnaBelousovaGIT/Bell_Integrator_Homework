package ru.sber.object.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Menu {
    private String name;
    private List<SubMenu> subMenuList = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SubMenu> getSubMenuList() {
        return subMenuList;
    }

    public void setSubMenuList(List<SubMenu> subMenuList) {
        this.subMenuList = subMenuList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Menu menu = (Menu) o;
        return Objects.equals(getName(), menu.getName()) &&
                Objects.equals(getSubMenuList(), menu.getSubMenuList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSubMenuList());
    }

    @Override
    public String toString() {
        return "Menu{" +
                "name='" + name + '\'' +
                ", subMenuList=" + subMenuList +
                '}';
    }
}
