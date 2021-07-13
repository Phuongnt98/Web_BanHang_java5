package com.poly.tiles;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
public class McvConfig implements WebMvcConfigurer {

		@Override
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
			exposeDirectory("uploads", registry);
		}
		public void exposeDirectory(String dirName, ResourceHandlerRegistry registry) {
			Path uploadDir = Paths.get(dirName);
			String uploadpath = uploadDir.toFile().getAbsolutePath();
			if (dirName.startsWith("../")) {
				dirName = dirName.replace("../", "");
				
			}
			registry.addResourceHandler("/"+dirName+"/**").addResourceLocations("file:/"+uploadpath+"/");
		}
}
