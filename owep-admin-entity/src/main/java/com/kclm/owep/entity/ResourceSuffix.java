package com.kclm.owep.entity;

import java.util.Objects;

public class ResourceSuffix {

   private String resourceSuffix;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ResourceSuffix{");
        sb.append("resourceSuffix='").append(resourceSuffix).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResourceSuffix that = (ResourceSuffix) o;
        return Objects.equals(resourceSuffix, that.resourceSuffix);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resourceSuffix);
    }

    public String getResourceSuffix() {
        return resourceSuffix;
    }

    public void setResourceSuffix(String resourceSuffix) {
        this.resourceSuffix = resourceSuffix;
    }

    public ResourceSuffix() {
    }

    public ResourceSuffix(String resourceSuffix) {
        this.resourceSuffix = resourceSuffix;
    }
}
