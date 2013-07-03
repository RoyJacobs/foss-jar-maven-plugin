/**
 * Copyright 1&1 Internet AG, https://github.com/1and1/
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.oneandone.maven.plugins.fossjar;

import java.io.File;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Mirko Friedenhagen
 */
public class MyMojoTest {

    public MyMojoTest() {
    }

    /**
     * Test of execute method, of class MyMojo.
     */
    @Test
    public void testExecute() throws Exception {
        final File outputDirectory = new File("target/justfortest");
        final File touchFile = new File(outputDirectory, "touch.txt");
        MyMojo instance = new MyMojo(outputDirectory);
        instance.execute();
        assertTrue(touchFile + " does not exist", touchFile.exists());
        instance.execute();
        assertTrue(touchFile + " does not exist", touchFile.exists());
    }
}
