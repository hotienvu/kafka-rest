/**
 * Copyright 2015 Confluent Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 **/

package io.confluent.kafkarest.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Min;

public class PartitionOffsetRange {

  @Min(0)
  private Integer partition;
  @Min(0)
  private Long fromOffset;
  @Min(0)
  private Long toOffset;

  @JsonCreator
  public PartitionOffsetRange(@JsonProperty("partition") Integer partition,
                              @JsonProperty("from_offset") Long fromOffset,
                              @JsonProperty("to_offset") Long toOffset) {
    this.partition = partition;
    this.fromOffset = fromOffset;
    this.toOffset = toOffset;
  }

  @JsonProperty
  public Integer getPartition() {
    return partition;
  }

  public void setPartition(Integer partition) {
    this.partition = partition;
  }

  @JsonProperty
  public Long getFromOffset() {
    return fromOffset;
  }

  public void setFromOffset(Long offset) {
    this.fromOffset = offset;
  }

  @JsonProperty
  public Long getToOffset() {
    return toOffset;
  }

  public void setToOffset(Long offset) {
    this.toOffset = offset;
  }

  @Override
  public String toString() {
    return "PartitionOffsetRange{"
            + "partition=" + partition
            + ", fromOffset=" + fromOffset
            + ", toOffset='" + toOffset + '\''
            + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    PartitionOffsetRange that = (PartitionOffsetRange) o;

    if (fromOffset != null ? !fromOffset.equals(that.fromOffset) : that.fromOffset != null) {
      return false;
    }

    if (toOffset != null ? !toOffset.equals(that.toOffset) : that.toOffset != null) {
      return false;
    }

    if (partition != null ? !partition.equals(that.partition) : that.partition != null) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = partition != null ? partition.hashCode() : 0;
    result = 31 * result + (fromOffset != null ? fromOffset.hashCode() : 0);
    result = 31 * result + (toOffset != null ? toOffset.hashCode() : 0);
    return result;
  }
}