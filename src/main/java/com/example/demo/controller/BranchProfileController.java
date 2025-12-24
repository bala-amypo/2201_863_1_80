@RestController
@RequestMapping("/api/branches")
public class BranchProfileController {

    private final BranchProfileService service;

    public BranchProfileController(BranchProfileService service) {
        this.service = service;
    }

    @PostMapping
    public BranchProfile create(@RequestBody BranchProfile branch) {
        return service.createBranch(branch);
    }

    @PutMapping("/{id}/status")
    public BranchProfile update(@PathVariable Long id,
                                @RequestParam boolean active) {
        return service.updateBranchStatus(id, active);
    }

    @GetMapping("/{id}")
    public BranchProfile get(@PathVariable Long id) {
        return service.getBranchById(id);
    }

    @GetMapping
    public List<BranchProfile> getAll() {
        return service.getAllBranches();
    }

    @GetMapping("/lookup/{branchCode}")
    public BranchProfile getByCode(@PathVariable String branchCode) {
        return service.findByBranchCode(branchCode);
    }
}
