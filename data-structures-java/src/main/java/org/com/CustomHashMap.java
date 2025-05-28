package org.com;

import com.sun.jdi.request.DuplicateRequestException;

import java.util.Iterator;
import java.util.Random;
import java.util.random.RandomGenerator;

public class CustomHashMap
{
  private static class CustomNode
  {
    CustomNode prevNode;
    CustomNode nextNode;
    Integer    value;

    public CustomNode( Integer value ) {
      this.prevNode = null;
      this.nextNode = null;
      this.value = value;
    }

    public CustomNode( CustomNode prev, Integer value ) {
      this.prevNode = prev;
      this.nextNode = null;
      this.value = value;
    }

    public CustomNode( CustomNode prev, CustomNode next, Integer value ) {
      this.prevNode = prev;
      this.nextNode = next;
      this.value = value;
    }
  }

  private CustomNode[] nodes;

  public CustomHashMap( int initialNumber ) {
    this.nodes = new CustomNode[initialNumber];
  }

  public Integer get( int value ) {
    int arrayIndex = hashFunc( value );

    if ( this.nodes[arrayIndex] == null ) {
      return null;
    }

    if ( this.nodes[arrayIndex].value == value ) {
      return value;
    }

    CustomNode current = this.nodes[arrayIndex].nextNode;

    while ( current != null ) {
      if ( current.value == value ) {
        return value;
      }
      current = current.nextNode;
    }

    return null;
  }

  public boolean set(int value) {
    int arrayIndex = hashFunc(value);

    if (this.nodes[arrayIndex] == null) {
      this.nodes[arrayIndex] = new CustomNode(value);
      return true;
    }

    if (this.nodes[arrayIndex].value == value) {
      throw new DuplicateRequestException("Such value already exists");
    }

    CustomNode current = this.nodes[arrayIndex];
    while (current.nextNode != null) {
      current = current.nextNode;
      if (current.value == value) {
        throw new DuplicateRequestException("Such value already exists");
      }
    }

    // Add new node at end
    current.nextNode = new CustomNode(current, value);
    return true;
  }

  public boolean delete(int value) {
    int arrayIndex = hashFunc(value);
    CustomNode current = this.nodes[arrayIndex];

    if (current == null) return false;

    if (current.value == value) {
      if (current.nextNode != null) {
        this.nodes[arrayIndex] = current.nextNode;
        this.nodes[arrayIndex].prevNode = null;
      } else {
        this.nodes[arrayIndex] = null;
      }
      return true;
    }

    while (current != null) {
      if (current.value == value) {
        if (current.prevNode != null) {
          current.prevNode.nextNode = current.nextNode;
        }
        if (current.nextNode != null) {
          current.nextNode.prevNode = current.prevNode;
        }
        return true;
      }
      current = current.nextNode;
    }

    return false;
  }

  private int hashFunc( int value ) {
    return value % this.nodes.length;
  }
}

