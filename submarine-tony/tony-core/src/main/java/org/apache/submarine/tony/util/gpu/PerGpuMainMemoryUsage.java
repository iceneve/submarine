/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. See accompanying LICENSE file.
 */

package org.apache.submarine.tony.util.gpu;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.apache.hadoop.classification.InterfaceAudience;
import org.apache.hadoop.classification.InterfaceStability;


@InterfaceAudience.Private
@InterfaceStability.Unstable
@XmlRootElement(name = "bar1_memory_usage")
public class PerGpuMainMemoryUsage {
  long usedMemoryMiB = -1L;
  long availMemoryMiB = -1L;

  @XmlJavaTypeAdapter(PerGpuDeviceInformation.StrToMemAdapter.class)
  @XmlElement(name = "used")
  public Long getUsedMemoryMiB() {
    return usedMemoryMiB;
  }

  public void setUsedMemoryMiB(Long usedMemoryMiB) {
    this.usedMemoryMiB = usedMemoryMiB;
  }

  @XmlJavaTypeAdapter(PerGpuDeviceInformation.StrToMemAdapter.class)
  @XmlElement(name = "free")
  public Long getAvailMemoryMiB() {
    return availMemoryMiB;
  }

  public void setAvailMemoryMiB(Long availMemoryMiB) {
    this.availMemoryMiB = availMemoryMiB;
  }

  public long getTotalMemoryMiB() {
    return usedMemoryMiB + availMemoryMiB;
  }
}