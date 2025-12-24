@RestController
@RequestMapping("/api/merge-records")
public class EventMergeController {

    private final EventMergeService service;

    public EventMergeController(EventMergeService service) {
        this.service = service;
    }

    @PostMapping
    public EventMergeRecord merge(@RequestParam List<Long> eventIds,
                                  @RequestParam String reason) {
        return service.mergeEvents(eventIds, reason);
    }

    @GetMapping("/{id}")
    public EventMergeRecord get(@PathVariable Long id) {
        return service.getMergeRecordById(id);
    }

    @GetMapping
    public List<EventMergeRecord> all() {
        return service.getAllMergeRecords();
    }

    @GetMapping("/range")
    public List<EventMergeRecord> range(@RequestParam LocalDate start,
                                        @RequestParam LocalDate end) {
        return service.getMergeRecordsByDate(start, end);
    }
}
