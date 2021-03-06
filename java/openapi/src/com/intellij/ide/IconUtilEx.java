/*
 * Copyright 2000-2009 JetBrains s.r.o.
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
 */
package com.intellij.ide;

import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleType;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Iconable;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.util.IconUtil;
import com.intellij.util.xml.ElementPresentationManager;

import javax.swing.*;

public class IconUtilEx {

  public static Icon getIcon(Object object, @Iconable.IconFlags int flags, Project project) {
    if (object instanceof PsiElement) {
      return ((PsiElement)object).getIcon(flags);
    }
    if (object instanceof Module) {
      return ModuleType.get((Module)object).getIcon();
    }
    if (object instanceof VirtualFile) {
      VirtualFile file = (VirtualFile)object;
      return IconUtil.getIcon(file, flags, project);
    }
    return ElementPresentationManager.getIcon(object);
  }
}
