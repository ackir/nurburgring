package com.aytunccankir.nurburgring.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.view.RedirectView
import springfox.documentation.annotations.ApiIgnore

import javax.servlet.http.HttpServletResponse

@RestController
@RequestMapping("/")
@ApiIgnore
class IndexController {

    @GetMapping
    fun redirectToSwaggerUi(response: HttpServletResponse): RedirectView {
        response.setHeader("Cache-Control", "no-cache")
        return RedirectView("/swagger-ui.html")
    }
}
