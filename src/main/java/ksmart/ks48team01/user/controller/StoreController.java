package ksmart.ks48team01.user.controller;

import com.google.gson.Gson;
import ksmart.ks48team01.dto.Store;
import ksmart.ks48team01.service.ContentsService;
import ksmart.ks48team01.service.StoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller("storeController")
@RequestMapping("/user/store")
public class StoreController {

    private final StoreService storeService;
    private final ContentsService contentsService;

    public StoreController(StoreService storeService, ContentsService contentsService) {
        this.storeService = storeService;
        this.contentsService = contentsService;
    }


    @GetMapping("/nuriStore")
    public String nuriStoreList(Model model) {
        List<Store> storeOfContentList = storeService.storeOfContentInfo();
        List<Store> categoryList = storeService.storeCategoryList();
        Store specificStoreList = storeService.specificStoreInfo();
        Store contentsListByStore = storeService.contentsListByStore();
        model.addAttribute("storeOfContentList", storeOfContentList);
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("specificStoreList", specificStoreList);
        model.addAttribute("contentsListByStore", contentsListByStore);

        return "user/store/nuriStore";
    }

    @ResponseBody
    @PostMapping("/storeRegister")
    public int storeRegister(@RequestBody Store store) {
        int registerResult = storeService.storeRegister(store);

        return registerResult;
    }

    /**
     * Get 방식의 Ajax 통신으로 취득할 수 있는
     * 유저 페이지 및 기타 간단한 가맹점 정보 목록
     * @param storeKeyword 가맹점의 NuriStore 페이지에서 View 상의 키워드 클릭 시
     *                     Ajax 통신으로 값을 입력받음
     * @return 입력받은 키워드에 해당되는 List
     */
    @ResponseBody
    @GetMapping("/storeKeywordList")
    public String storeKeywordList(@RequestParam (name = "storeKeyword", required = false) String storeKeyword) {
        Gson gson = new Gson();

        List<Store> keywordList = null;

        if(storeKeyword != null) {
            keywordList = storeService.getStoreKeyword(storeKeyword);
        } else {
            keywordList = storeService.getStoreKeyword();
        }

        return gson.toJson(keywordList);
    }

}
