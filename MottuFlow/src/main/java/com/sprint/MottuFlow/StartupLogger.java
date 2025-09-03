package com.sprint.MottuFlow;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class StartupLogger {
	
	@EventListener(ApplicationReadyEvent.class)
	public void logWhenReady() {
		System.out.print("\n".repeat(60));
		System.out.println(
				"███╗░░░███╗░█████╗░████████╗████████╗██╗░░░██╗███████╗██╗░░░░░░█████╗░░██╗░░░░░░░██╗\n" +
				"████╗░████║██╔══██╗╚══██╔══╝╚══██╔══╝██║░░░██║██╔════╝██║░░░░░██╔══██╗░██║░░██╗░░██║\n" +
				"██╔████╔██║██║░░██║░░░██║░░░░░░██║░░░██║░░░██║█████╗░░██║░░░░░██║░░██║░╚██╗████╗██╔╝\n" +
				"██║╚██╔╝██║██║░░██║░░░██║░░░░░░██║░░░██║░░░██║██╔══╝░░██║░░░░░██║░░██║░░████╔═████║░\n" +
				"██║░╚═╝░██║╚█████╔╝░░░██║░░░░░░██║░░░╚██████╔╝██║░░░░░███████╗╚█████╔╝░░╚██╔╝░╚██╔╝░\n" +
				"╚═╝░░░░░╚═╝░╚════╝░░░░╚═╝░░░░░░╚═╝░░░░╚═════╝░╚═╝░░░░░╚══════╝░╚════╝░░░░╚═╝░░░╚═╝░░\n" +
				"\n" +
				"░█████╗░███╗░░██╗██╗░░░░░██╗███╗░░██╗███████╗██╗\n" +
				"██╔══██╗████╗░██║██║░░░░░██║████╗░██║██╔════╝██║\n" +
				"██║░░██║██╔██╗██║██║░░░░░██║██╔██╗██║█████╗░░██║\n" +
				"██║░░██║██║╚████║██║░░░░░██║██║╚████║██╔══╝░░╚═╝\n" +
				"╚█████╔╝██║░╚███║███████╗██║██║░╚███║███████╗██╗\n" +
				"░╚════╝░╚═╝░░╚══╝╚══════╝╚═╝╚═╝░░╚══╝╚══════╝╚═╝ \n");
		
		System.out.println("🌐 Acesse aqui:   http://localhost:8080\n");
		System.out.println("📖 Swagger UI:   http://localhost:8080/swagger-ui/index.html");
		System.out.println("_____________________________________________________________\n");
	}
}
