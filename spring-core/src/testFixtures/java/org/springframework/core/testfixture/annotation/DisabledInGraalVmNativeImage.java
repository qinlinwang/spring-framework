/*
 * Copyright 2002-2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.core.testfixture.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.jupiter.api.condition.DisabledIfSystemProperty;

/**
 * Indicates that the annotated test class or test method is disabled when
 * executing within a GraalVM native image (at agent time, build time, or run time).
 *
 * <p>When executing tests within a GraalVM native image, consult the documentation for
 * <a href="https://github.com/oracle/graal/blob/master/substratevm/LIMITATIONS.md">Native
 * Image Java Limitations</a>.
 *
 * <p>Primarily intended for tagging JUnit Jupiter based test classes and test methods.
 *
 * @author Sam Brannen
 * @since 5.2.5
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Inherited
@Documented
@DisabledIfSystemProperty(named = "org.graalvm.nativeimage.imagecode", matches = ".+")
public @interface DisabledInGraalVmNativeImage {

	/**
	 * Optional reason.
	 */
	String value();

}
