package ru.sber.object.model;

import java.util.Objects;

public class SubMenu {
    private String name;
    private String href;

    public SubMenu() {
    }

    public SubMenu(String name, String href) {
        this.name = name;
        this.href = href;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SubMenu subMenu = (SubMenu) o;
        return Objects.equals(name, subMenu.name) &&
                Objects.equals(href, subMenu.href);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, href);
    }

    @Override
    public String toString() {
        return "SubMenu{" +
                "name='" + name + '\'' +
                ", href='" + href + '\'' +
                '}';
    }
}
